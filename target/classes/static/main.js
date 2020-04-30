

function fire_ajax_submit() {
    alert("aaaaaaaaaaaaa");
    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            alert(data);
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}