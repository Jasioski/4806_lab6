$(document).ready(
    function() {

        $("#registerBuddyForm").submit(function(event) {
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {
            $.ajax({
                type : "POST",
                contentType : "application/json",
                data : JSON.stringify(formData),
                dataType : 'json'
            }).then(function(data) {
                console.log(data);
            })
        }
    });