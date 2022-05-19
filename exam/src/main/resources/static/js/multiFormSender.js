$(document).ready(function () {

    $(this).submit(function (event) {

      event.preventDefault();

      var data_sum = $('#entrances').serializeArray();


      $.ajax({
          url: '/api/entrances/' + data_sum,
          type: 'POST',
      })
          .done(function (result) {
              alert('Added ' + result.text);
          })
          .fail(function (jqXHR, result) {

              alert('Error ' + result.text +' ' + jqXHR.status);
          })

      console.log(data_sum);

  });
});