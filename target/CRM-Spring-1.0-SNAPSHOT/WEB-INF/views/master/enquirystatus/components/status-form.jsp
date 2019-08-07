<div id="status-dialog" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"></h4>
            </div>
            <form id="status-form">
                <div class="modal-body">

                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" id="status-name" name="name" required="required" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Color</label>
                        <input type="text" id="status-color" name="color" required="required" class="form-control"/>
                    </div>
                </div>
                <div class="modal-footer">
                      <input type="hidden" id="status-id" name="id" value=""/>
                      <%@include file="../../../shared/components/form-button.jsp" %>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->