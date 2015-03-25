var storedData = {};
var assistanceServed;
var deliveryServed;

$(document).ready(function () {
    setInterval(function () {
        $.getJSON("updateQueues", {labId: $("#labId").val()}, function (data) {
            if (JSON.stringify(data) != JSON.stringify(storedData)) {
                $("#assistance").html("");
                for (var i = 0; i < data.AssistanceQueues.length; i++) {
                    $("#assistance").append(
                        "<tr>" +
                        "<td>" + (i+1) + "</td>" +
                        "<td>" + data.AssistanceQueues[i].user.username + "</td>" +
                        "<td>" + data.AssistanceQueues[i].user.email + "</td>" +
                        "</tr>"
                    );
                }

                $("#delivery").html("");
                for (var i = 0; i < data.DeliveryQueues.length; i++) {
                    $("#delivery").append(
                        "<tr>" +
                        "<td>" + (i+1) + "</td>" +
                        "<td>" + data.DeliveryQueues[i].user.username + "</td>" +
                        "<td>" + data.DeliveryQueues[i].user.email + "</td>" +
                        "</tr>"
                    );
                }

                // notification is shown when queues change and currently served persons are updated
                if (JSON.stringify(storedData) !== "{}") {
                    if (storedData.AssistanceQueues.length != data.AssistanceQueues.length) {
                        $("#assistanceServed").html(storedData.AssistanceQueues[0].user.username + " is currently being assisted");
                    }
                    if (storedData.DeliveryQueues.length != data.DeliveryQueues.length) {
                        $("#deliveryServed").html(storedData.DeliveryQueues[0].user.username + " is currently delivering");
                    }

                    $("#notification").show();
                    setTimeout(function() {
                        $("#notification").hide();
                    }, 5000)
                }
                storedData = data;
            }
        });
    }, 1000);
});