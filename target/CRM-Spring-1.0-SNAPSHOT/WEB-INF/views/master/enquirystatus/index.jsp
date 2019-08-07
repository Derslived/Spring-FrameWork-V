<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiry Status</h1>
</div>

<div class="pull-right">
    <p>
        <a href="javascript:void(0)" id="add-btn" class="btn btn-primary btn-xs" title="Add Enquiry Status">
            <span class="glyphicon glyphicon-plus"></span>
        </a>


    </p>


</div>


<div id="view-content">

</div>

<%@include file="components/status-form.jsp" %>

<script>

    function load() {
        var $content = $("#view-content").html('<h1>Loading.......</h1>');
        $.get('${SITE_URL}/admin/master/enquiry/status/table', function (data) {

            $content.html(data);


        });

    }

    $(document).ready(function () {



        load();
        $("#add-btn").on('click', function () {

            let $dialog = $('#status-dialog');
            $dialog.find('.modal-title').html('Add Enquiry Status');
            $dialog.modal();
            $('input').val(''); 
            $("status-id").val(0);

        });

        $("#status-form").on('submit', function () {

            $.ajax({
                url: '${SITE_URL}/admin/master/enquiry/status/save',
                method: 'post',
                data: $("#status-form").serialize(),
                success: function (resp) {

                    if (resp) {
                        $("#status-dialog").modal('hide');
                        load();

                    }

                }

            });
            return false;
        });

    });
</script>


<%@include file="../../shared/footer.jsp" %>
