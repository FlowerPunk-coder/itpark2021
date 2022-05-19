$(function () {
    $('#del-distr').click(function () {
        let id = $('#district').val();
        let name = $("#district option:selected").text();
        if (id == null) {
            alert("Выберите район для удаления");
            return;
        }
        if (confirm("Удалить район: " + name +
            " и все улицы этого района?")) {
            $.ajax({
                url: "/api/districts/" + id,
                type: "DELETE",
                success: function () {
                    location.href = "/add";
                }
            });
        }
    });
    $('#del-street').click(function () {
        let id = $('#street').val();
        let name = $("#street option:selected").text();
        if (id == null) {
            alert("Выберите улицу для удаления");
            return;
        }
        if (confirm("Удалить: " + name + "? \n" +
            "Это удалит все дома связанные с ней")) {
            $.ajax({
                url: "/api/streets/" + id,
                type: "DELETE",
                success: function () {
                    location.href = "/add";
                }
            });
        }
    });
    $('#del-house').click(function () {
        let id = $('#house').val();
        let name = $("#house option:selected").text();
        if (id == null) {
            alert("Выберите дом для удаления");
            return;
        }
        if (confirm("Удалить дом: " + name + "?")) {
            $.ajax({
                url: "/api/houses/" + id,
                type: "DELETE",
                success: function () {
                    location.href = "/add";
                }
            });
        }
    });
});