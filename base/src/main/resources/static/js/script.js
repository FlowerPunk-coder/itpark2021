$(function (){

    $('#button').click(function () {
        let arg1 = $('#first').val();
        let arg2 = $('#sel-to').select();

        if (!arg1 || arg1 < 0) {
            $('#first').focus();
            alert('Введите значение которое хотите перевести в ' + arg2.val() + '\n'
            + 'Значение не может быть ниже нуля!')

        } else {
            $.ajax({
                url: '/exchange/valute?arg1=' + arg1 + '&arg2=' + arg2.val(),
                type: 'POST',
                success: function (result) {
                    $('#result').text(arg1 + ' ' + arg2.val() + ' = ' + result.value + ' ₽')
                        .css("visibility", "visible");
                },
                error: function (result) {
                    $('#result').text('Что-то пошло не так ' + result.value);
                }
            });
        }

    });
});