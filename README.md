# Prerequisite

OPENPAAS APP를 생성하기 전에 먼저 계정을 등록후  rhc client tool를 설치 하여야 합니다.

# Step 1: DIY Application 생성하기

To create an application using client tools, type the following command:

    rhc create-app todo diy-0.1

이 명령어를 실행하여 하위 폴더로 todo 라는 프로젝트가 생성 된다.

# Step 2: DIY 템플릿코드 삭제 

todo 폴더안에 생성된 파일을 삭제한다:

    git rm -rf .openshift README.md diy misc

git Commit 처리:

    git commit -am "Removed"

# Step 3: Pull Source code from GitHub

    git remote add upstream https://github.com/lucasjo/todo.git
    git pull --allow-unrelated-histories -s recursive -X theirs upstream master

# Step 4: Push changes

The basic template is ready to be pushed:

	git push

URL 에 접속해 보면 todo-<namespace>.cloud.or.kr

