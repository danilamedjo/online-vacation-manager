function kategorijeService($http, $log) {

	var apiKategorije = "/api/kategorije";

	this.getKategorije = function(cb) {

		$log.log("Called getKategorije function")

		$http.get(apiKategorije)
		.then(
				function success(res) {
					cb(res);
				}, 
				function error(res) {
					$log.error("Couldn't fetch kategorije");
				});
		};
}