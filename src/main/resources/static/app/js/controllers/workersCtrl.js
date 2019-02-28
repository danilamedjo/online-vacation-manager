function workersCtrl($scope, $location, $log, workerService, departmentService) {

	$log.log("Instantiating workersCtrl");

	$scope.selectedWorker = {};

	$scope.departments = [];
	$scope.workers = [];

	// $scope.newWorker = {
	// 	identityNumber = "",
	// 	fullName = "",
	// 	email = "",
	// 	yearsOfService = "",
	// 	departmentId = ""
	// };

	const searchParamsInit = {
		"identityNumber" : "",
		"fullName" : "",
		"departmentId" : 0
	};

	const newWorkerInit = {
		"identityNumber" : "",
		"fullName" : "",
		"email" : "",
		"yearsOfService" : 0,
		"freeDays" : 0,
		"departmentId" : 0
	}

	const departmentInit = {
		"id" : 0,
		"name" : ""
	}

	$scope.searchParams = Object.create(searchParamsInit);
	$scope.newWorker = Object.create(newWorkerInit);
	$scope.department = Object.create(departmentInit);

	

	$scope.pageSizeOptions = [ 5, 10, 20 ];
	$scope.pageNum = 0;
	$scope.defaultValue = 5;
	$scope.totalPages = 1;
	$scope.pageSize = $scope.pageSizeOptions[0];

	var getWorkers = () => {

		var config = {
			params : {}
		};

		config.params.pageNum = $scope.pageNum;
		config.params.pageSize = $scope.pageSize;

		workerService.getWorkers(config, function(res) {
			$scope.workers = res.data;
			$scope.totalPages = res.headers('totalPages');
		});

	};

	var getDepartments = () => {
		departmentService.getDepartments(function(res) {
			$scope.departments = res.data;
		});
	};

	getWorkers();
	getDepartments();

	$scope.addWorker = () => {
		workerService.addWorker($scope.newWorker, function(res) {

			getWorkers();

			document.getElementById("addForm").reset();

			$scope.addForm.$setPristine();
			$scope.addForm.$setUntouched();

			$scope.newWorker = newWorker;

		});
	};

	$scope.deleteWorker= id => {
		workerService.deleteWorker(id, function(res) {
			getWorkers();
		});
	};

	$scope.editWorker = aid => {
		$location.path('/workers/edit/' + aid);
	};

	$scope.selectWorker = id => {
		$scope.selectedId = id;
		
		workerService.getWorker(id, res => {
			$scope.selectedWorker = res.data;
		});
	};

	$scope.searchWorkers = () => {

		var config = {
			params : {}
		};
		
		if($scope.searchParams.identityNumber != ""){
			config.params.identityNumber = $scope.searchParams.identityNumber;
		}
		
		if($scope.searchParams.fullName != ""){
			config.params.fullName = $scope.searchParams.fullName;
		}

		if($scope.searchParams.departmentId != ""){
			config.params.departmentId = $scope.searchParams.departmentId;
		}

		$scope.pageNum = 0;

		workerService.getWorkers(config, res => {
			$scope.workers = res.data;
			$scope.totalPages = res.headers('totalPages');
		});

		document.getElementById("searchForm").reset();

		$scope.searchForm.$setPristine();
		$scope.searchForm.$setUntouched();

		config.params = Object.create(searchParamsInit);
	    $scope.searchParams = Object.create(searchParamsInit);

	};

	$scope.previous = () => {
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getWorkers();
        }
    };

    $scope.next = () => {
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getWorkers();
        }
    };
    
    
    $scope.funkcija = () => {
    	$scope.karta.workerId = $scope.selectedWorker.id;
    	kartaService.add($scope.karta, function(res){
    		
    	});
    }

}