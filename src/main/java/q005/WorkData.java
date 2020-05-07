package q005;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
public class WorkData {
    /**
     * 社員番号
     */
    private String number;

    /**
     * 部署
     */
    private String department;

    /**
     * 役職
     */
    private String position;

    /**
     * Pコード
     */
    private String pCode;

    /**
     * 作業時間(分)
     */
    private int workTime;

    public WorkData(String number, String department, String position, String pCode, int workTime) {
        this.number = number;
        this.department = department;
        this.position = position;
        this.pCode = pCode;
        this.workTime = workTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
