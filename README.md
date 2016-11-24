# Prerequisite

OPENPAAS APP를 생성하기 전에 먼저 계정을 등록후  rhc client tool를 설치 하여야 합니다.

# Step 1: DIY Application 생성하기

To create an application using client tools, type the following command:

    rhc create-app todo diy-0.1

이 명령어를 실행하여 하위 폴더로 todo 라는 프로젝트가 생성 된다.

# Step 3: Delete Template Application Source code

OpenShift creates a template project that can be freely removed:

    git rm -rf .openshift README.md diy misc

Commit the changes:

    git commit -am "Removed template application source code"

# Step 4: Pull Source code from GitHub

    git remote add upstream https://github.com/kolorobot/openshift-diy-spring-boot-sample.git
    git pull -s recursive -X theirs upstream master

# Step 5: Push changes

The basic template is ready to be pushed:

	git push

The initial deployment (build and application startup) will take some time (up to several minutes). Subsequent deployments are a bit faster, although starting Spring Boot application may take even more than 2 minutes on small Gear:

	Tomcat started on port(s): 8080/http
	Started Application in 125.511 seconds

You can now browse to: http://boot-<namespace>.rhcloud.com/manage/health and you should see:

	{
		"status": "UP",
		"database": "PostgreSQL",
		"hello": 1
	}

You can then browse to "/" to see the API root resource.

# Step 6: Adding Jenkins

Using Jenkins has some advantages. One of them is that the build takes place in it's own Gear. To build with Jenkins, OpenShift needs a server and a Jenkins client cartridge attached to the application. Creating Jenkins application:

	rhc app create ci jenkins

And attaching Jenkins client to the application:

	rhc cartridge add jenkins-client --app boot

You can now browse to: http://ci-<namespace>.rhcloud.com and login with the credentials provided. When you make next changes and push them, the build will be triggered by Jenkins:

	remote: Executing Jenkins build.
	remote:
	remote: You can track your build at https://ci-<namespace>.rhcloud.com/job/boot-build
	remote:
	remote: Waiting for build to schedule.........

And when you observe the build result, the application starts a bit faster on Jenkins:

	Started Application in 52.391 seconds

# Under the hood

http://blog.codeleak.pl/2014/10/spring-boot-java-8-tomcat-8-on-openshift.html