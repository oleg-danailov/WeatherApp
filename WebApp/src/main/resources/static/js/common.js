function searchCity() {
        $('#container').empty();
        $('#container').append("<p>Loading…</p>");
        var text = $('#searchBox').val();
        var url = $('#searchBox').attr('url');
        //make call to /table
        url = url + "?cityName=" + text;
        $.ajax({
          url: url
        })
        .done(function(data) {
            $('#container').empty();
            $('#container').append(data);
        });
    }

function geoFindMe() {

        var output = document.getElementById("container");

      if (!navigator.geolocation){
        output.innerHTML = "<p>Geolocation is not supported by your browser</p>";
        return;
      }

  function success(position) {
    var latitude  = position.coords.latitude;
    var longitude = position.coords.longitude;

//    output.innerHTML = '<p>Latitude is ' + latitude + '° <br>Longitude is ' + longitude + '°</p>';
        var url = $('#searchBox').attr('url');
            url = url + "?lon=" + longitude + "&lat=" + latitude;
            $.ajax({
              url: url
            })
            .done(function(data) {
                $('#container').empty();
                $('#container').append(data);
            });

  }

  function error() {
    output.innerHTML = "Unable to retrieve your location";
  }

  output.innerHTML = "<p>Locating…</p>";

  navigator.geolocation.getCurrentPosition(success, error);
}