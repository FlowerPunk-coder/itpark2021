$(function () {

    $('#district').change(function () {
        let id = $(this).val();
        if (id == null) {
            $('.add-street').fadeOut('slow');
            return
        }
        var defOpt = "<option disabled selected>Выберите улицу</option>";
        $('#street').empty().trigger("change").append(defOpt);
        var defHouseOpt = "<option disabled selected>Выберите дом</option>"
        $('#house').empty().trigger("change").append(defHouseOpt);
        $.ajax({
            url: '/smc/street/' + id,
            type: 'GET',
            success: function (result) {
                $('.add-street').fadeIn('slow');
                for (let i = 0; i < result.length; i++) {
                    var option = "<option value = " + result[i].id + ">" + result[i].name + "</option>";
                    $('#street').append(option);
                }
            }
        })
    });


    $('#street').change(function () {
        let id = $(this).val();
        if (id == null) {
            $('.add-house').fadeOut('slow');
            return
        }
        var defHouseOpt = "<option disabled selected>Выберите дом</option>"
        $('#house').empty().trigger("change").append(defHouseOpt);
        $.ajax({
            url: '/smc/houses/' + id,
            type: 'GET',
            success: function (result) {
                $('.add-house').fadeIn('slow');
                for (let i = 0; i < result.length; i++) {
                    let prefix = result[i].prefix === 0 ? "" : result[i].prefix;
                    var option = "<option value = " + result[i].id + ">" + result[i].number +
                        result[i].sing + prefix + "</option>";
                    $('#house').append(option);
                }
            }
        })
    });


    $('#house').change(function () {
        let id = $(this).val();
        if (id == null) {
            $('#house-data').fadeOut('slow');
            $('#btn-check').attr('disabled', true);
            return;
        } else {
            $('#btn-check').attr('disabled', false);
        }
        $.ajax({
            url: '/smc/house/' + id,
            type: 'GET',
            success: function (result) {
                let prefix = result.prefix === 0 ? "" : result.prefix;
                $("#house-num").text(' ' + result.number + result.sing + prefix);
                var obj;
                var date = new Date(result.date).toLocaleDateString();
                if (result.checked) {
                    obj = "<img id='img-check'  src='/images/yesCheck.png'><br><br>" +
                        "<p>" + date + "</p>";
                } else {
                    obj = "<img id='img-check'  src='/images/noCheck.png'>";
                }
                $('#house-check').html(obj);
                $('#house-data').fadeIn('slow');
            }
        });

    });
});
