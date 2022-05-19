$(document).ready(function () {

    $('#entrances').submit(function (event) {

      event.preventDefault();

      var data =

      $.post({
          url: "/api/entrances/"
      })

      console.log(data);

  });
});