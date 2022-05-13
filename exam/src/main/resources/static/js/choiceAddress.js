$(function (){
    $(function () {
        $('#district').change(function () {
            let id = $(this).val();
            if (id == null) {
                $('#street').fadeOut('slow');
                return
            }
            var defOpt = "<option disabled selected>Выберите улицу</option>";
            $('#street').empty().trigger("change").append(defOpt);
            $.ajax({
                url: '/smc/street/' + id,
                type: 'GET',
                success: function (result) {
                    $('#street').fadeIn('slow');
                    for (let i = 0; i < result.length; i++) {
                        var option = "<option value = " + result[i].id + ">" + result[i].name + "</option>";
                        $('#street').append(option);
                    }
                }
            })
        });
    });

    $(function () {
        $('#street').change(function () {
            let id = $(this).val();
            if (id == null) {
                $('#house').fadeOut('slow');
                return
            }
            var defOpt = "<option disabled selected>Выберите дом</option>"
            $('#house').empty().trigger("change").append(defOpt);
            $.ajax({
                url: '/smc/houses/'+ id,
                type: 'GET',
                success: function (result) {
                    $('#house').fadeIn('slow');
                    for (let i = 0; i < result.length; i++) {
                        var option = "<option value = " + result[i].id + ">" + result[i].number +
                            result[i].sing + result[i].prefix + "</option>";
                        $('#house').append(option);
                    }
                }
            })
        });
    });

    $(function () {
        $('#house').change(function () {
            let id = $(this).val();
            if (id == null) {
                $('#house-data').fadeOut('slow');
                return;
            }

            $.ajax({
                url: '/smc/house/' + id,
                type: 'GET',
                success: function (result) {
                    $("#house-num").text(' ' + result.number + result.sing + result.prefix);
                    $("#house-entry").text(' ' + result.numberOfEntrances);
                    $("#house-sys").text(' ' + result.numberOfSystems);
                    $('#house-data').fadeIn('slow');
                }
            })

        });
    });

})
