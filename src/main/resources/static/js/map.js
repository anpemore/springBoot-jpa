function map(){
    alert("joder");
    var coord = {lat:10.250840, lng: 75.321788};
    var map = new google.maps.Map(document.getElementById('map'),{
      zoom: 10,
      center: coord
    });
    var marker = new google.maps.Marker({
      position: coord,
      map: map
    });
}