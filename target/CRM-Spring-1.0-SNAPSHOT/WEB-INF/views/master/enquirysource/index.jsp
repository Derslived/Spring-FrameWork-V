<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiry Source</h1>
</div>

<div class="pull-right">
    <p>
        <a href="javascript:void(0)" id="add-btn" class="btn btn-primary btn-xs" title="Add Enquiry Source">
            <span class="glyphicon glyphicon-plus"></span>
        </a>


    </p>


</div>


<div id="view-content">

</div>

<%@include file="components/source-form.jsp" %>

<script>

    function load() {
        var $content = $("#view-content").html('<h1>Loading.......</h1>');
        $.get('${SITE_URL}/admin/master/enquiry/source/table', function (data) {

            $content.html(data);


        });

    }

    $(document).ready(function () {



        load();
        $("#add-btn").on('click', function () {

            let $dialog = $('#source-dialog');
            $dialog.find('.modal-title').html('Add Enquiry Source');
            $dialog.modal();
            $('input').val(''); 
            $("source-id").val(0);

        });

        $("#source-form").on('submit', function () {

            $.ajax({
                url: '${SITE_URL}/admin/master/enquiry/source/save',
                method: 'post',
                data: $("#source-form").serialize(),
                success: function (resp) {

                    if (resp) {
                        $("#source-dialog").modal('hide');
                        load();

                    }

                }

            });
            return false;
        });

    });
</script>


<%@include file="../../shared/footer.jsp" %>
