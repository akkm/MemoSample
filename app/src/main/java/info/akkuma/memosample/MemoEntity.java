package info.akkuma.memosample;

/**
 * Created by akkuma on 2014/10/06.
 */
public class MemoEntity {

    public static final String TABLE_NAME = "memo_entity";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_TIME_STAMP = "time_stamp";

    private Integer id = null;
    private String text = null;
    private Long time_stamp = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTimeStamp() {
        return time_stamp;
    }

    public void setTimeStamp(Long time_stamp) {
        this.time_stamp = time_stamp;
    }
}
