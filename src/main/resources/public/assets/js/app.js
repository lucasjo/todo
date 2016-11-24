var app = angular.module(
		'todo',
		['ngRoute', 'ngResource', 'ngAnimate', 'ngSanitize', 'ngMaterial']
		);



app.controller('headerCtrl',  ['$scope','$timeout', '$mdSidenav','$log', function($scope, $timeout,$mdSidenav,$log){
	$scope.toggleRight = buildToggler('right');
    $scope.isOpenRight = function(){
      return $mdSidenav('right').isOpen();
    };
    
    function buildToggler(navID) {
        return function() {
          // Component lookup should always be available since we are not using `ng-if`
          $mdSidenav(navID)
            .toggle()
            .then(function () {
              //$log.debug("toggle " + navID + " is done");
            });
        }
    }
}]);

app.controller('appCtrl', ['$scope', '$timeout', '$log', '$http', function($scope, $time, log, $http){

	$scope.tabData = {};
	
	$scope.selectedIndex = 0;
	
	    
    $scope.findList = function(){
    	$http.get('/api/list').success(function(data){
    		$scope.resultList(data.list);
    	})
    }
    
    $scope.resultList = function(data){
    	
    	
    	var active = data.filter(function(v){
    		if(v.toDoSts === '01'){
    			return v;
    		}
    	})
    	
    	var complete = data.filter(function(v){
    		if(v.toDoSts === '02'){
    			return v;
    		}
    	})
    	
    	var tabData = [
    	               {
    	            	   text:'ALL',
    	            	   data:data
    	               },
    	               {
    	            	   text:'ACTIVE',
    	            	   data:active
    	               },
    	               {
    	            	   text:'COMPLETE',
    	            	   data:complete
    	               }
    	               
    	              ];
    	
    	angular.extend($scope.tabData, tabData);
    }
    
    $scope.init = function(){
    	$scope.findList();
    }
    
    $scope.init();
    
    $scope.doDone = function(todo){
    	todo.toDoSts = '02';
    	todo.sts = 'U'
    	$scope.edit(todo, '/api/edit');
    }
    
    $scope.doDelete = function(todo){    	
    	todo.sts = 'D'
    	$scope.edit(todo, '/api/delete');
    }
    
    $scope.edit = function(param, url){
    	$http({
			method : 'POST',
			data : param,
			url : url
		}).success(function(data){
			$scope.findList();
			if(!!~url.search('edit')){
				$scope.selectedIndex = 2;
			}else if(!!~url.search('delete')){
				$scope.selectedIndex = 0;
			}
		})
    }
    
    $scope.save = function(param){
    	$http({
			method : 'POST',
			data : param,
			url : '/api/add'
		}).success(function(data){
			$scope.findList();
			$scope.selectedIndex = 1;
		})
    }
    
    $scope.$on('addEvent', function(event, data){
    	data.toDoSts = "01";
		data.sts = "C";
		data.closeDt = new Date();		
		
		var param = {};
		angular.extend(param, data);
		$scope.save(param);
		
//		$http({
//			method : 'POST',
//			data : param,
//			url : '/api/add'
//		}).success(function(data){
//			$scope.findList();
//		})
    })
	
}]);


app.controller('RightCtrl', ['$scope','$timeout', '$mdSidenav','$log', '$rootScope', '$http', '$mdDialog', 
                             function($scope, $timeout,$mdSidenav,$log, $rootScope, $http, $mdDialog){
	
	$scope.data = {};
	
	$scope.addTodo = function(){
		
		if(!$scope.data.text){	
			$mdDialog.show(
		      $mdDialog.alert()
		        .parent(angular.element(document.querySelector('.scrollable-content')))
		        .clickOutsideToClose(true)
		        .title('알림')
		        .textContent('할일을 입력 해 주세요')
		        .ariaLabel('Alert')
		        .ok('확인')     
		        
		    ).then(function(){
		    	angular.element('#text').focus();
		    });
			
			return;
		}
		
		$mdSidenav('right').close()
		.then(function(){
			$scope.$emit('addEvent', $scope.data);
		});
		
		
		
	}	
}]);

