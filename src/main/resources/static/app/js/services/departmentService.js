function departmentService($http, $log) {

	var apiDepartments = "/api/departments";

	this.getDepartments = cb => {

		$log.log("Called getDepartments function")

		$http.get(apiDepartments)
		.then(
				function success(res) {
					cb(res);
				}, 
				function error(res) {
					$log.error("Couldn't fetch departments" + res.error);
				});
		};
}