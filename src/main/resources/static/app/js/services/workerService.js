function workerService($http, $log) {

	var apiWorkers = "/api/workers";

	this.getWorkers = (config, cb) => {

		$log.log("Called getWorkers function");

		$http.get(apiWorkers, config)
			.then(function success(res) {
				cb(res);
			}, function error(res) {
				$log.error("Couldn't fetch workers: " + res.error);
			});

	};

	this.addWorker = (worker, cb) => {

		$log.log("Called addWorker function");

		$http.post(apiWorkers, worker)
			.then(
				function success(res) {
					cb(res);
				},
				function error(res) {
					$log.error("Couldn't add worker " + res.status);
				});
	};

	this.deleteWorker = (id, cb) => {

		$log.log("Called deleteWorker function");

		$http.delete(apiWorkers + "/" + id)
			.then(
				function success(res) {
					cb(res);
				},
				function error(res) {
					$log.error("Couldn't delete worker");
				});
	};
		
	this.getWorker = (id, cb) => {
		
		$log.log("Called getWorker function");
		
		$http.get(apiWorkers + "/" + id)
		.then(
		function success(res){
			cb(res);
		},
		function error(res){
			$log.error("Couldn't get worker");
		});
	};
	
	this.editWorker = (id, worker, cb) => {
		
		$log.log("Called editWorker function");
		
		$http.put(apiWorkers + "/" + id, worker)
		.then(
		function success(res) {
			cb(res);
		},
		function error(res) {
			$log.error("Couldn't get worker");
		});
	};
		
}