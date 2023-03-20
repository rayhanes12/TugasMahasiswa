package Model;

public class ResponseModel {
    private String Message;
    private String Status;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    private String Comments;

    public ResponseModel(){
        this.Message = Message;
        this.Status = Status;
        this.Comments = Comments;

    }
}
