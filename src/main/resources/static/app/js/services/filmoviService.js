function filmoviService($http, $log) {

	var apiFilmovi = "/api/filmovi";

	this.getFilmovi = function (config, cb) {

		$log.log("Called getFilmovi function");

		$http.get(apiFilmovi, config)
			.then(function success(res) {
				cb(res);
			}, function error(res) {
				$log.error("Couldn't fetch filmovi");
			});

	};

	this.addFilm = function (film, cb) {

		$log.log("Called addFilm function");

		$http.post(apiFilmovi, film)
			.then(
				function success(res) {
					cb(res);
				},
				function error(res) {
					$log.error("Couldn't add film");
				});
	};

	this.deleteFilm = function (id, cb) {

		$log.log("Called deleteFilm function");

		$http.delete(apiFilmovi + "/" + id)
			.then(
				function success(res) {
					cb(res);
				},
				function error(res) {
					$log.error("Couldn't delete film");
				});
	};
		
	this.getFilm = function(id, cb) {
		
		$log.log("Called getFilm function");
		
		$http.get(apiFilmovi + "/" + id)
		.then(
		function success(res){
			cb(res);
		},
		function error(res){
			$log.error("Couldn't get film");
		});
	};
	
	this.editFilm = function(id, film, cb){
		
		$log.log("Called editFilm function");
		
		$http.put(apiFilmovi + "/" + id, film)
		.then(
		function success(res) {
			cb(res);
		},
		function error(res) {
			$log.error("Couldn't get film");
		});
	};
		
}