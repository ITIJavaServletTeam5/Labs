var storedData = {};

$(document).ready(function () {
    setInterval(function () {
        $.getJSON("updateQueues", {labId: $("#labId").val()}, function (data) {
            if (JSON.stringify(data) != JSON.stringify(storedData)) {
                $("#assistance").html("");
                for (var i = 0; i < data.AssistanceQueues.length; i++) {
                    console.log("loop");
                    $("#assistance").html(
                        "<tr>" +
                        "<td>" + (i+1) + "</td>" +
                        "<td>" + data.AssistanceQueues[i].user.username + "</td>" +
                        "<td>" + data.AssistanceQueues[i].user.email + "</td>" +
                        "</tr>"
                    );
                }

                $("#delivery").html("");
                for (var i = 0; i < data.DeliveryQueues.length; i++) {
                    console.log("loop");
                    $("#delivery").append(
                        "<tr>" +
                        "<td>" + (i+1) + "</td>" +
                        "<td>" + data.DeliveryQueues[i].user.username + "</td>" +
                        "<td>" + data.DeliveryQueues[i].user.email + "</td>" +
                        "</tr>"
                    );
                }
                storedData = data;
            }
        });
    }, 1000);
});