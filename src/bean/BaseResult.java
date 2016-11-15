package bean;

/**
 * Created by Administrator
 * on 2016/6/13.
 */
public class BaseResult {
    String retCode;
    String retInfo;

    public BaseResult() {
    }

    public BaseResult(String retCode, String retInfo) {
        this.retCode = retCode;
        this.retInfo = retInfo;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "retCode='" + retCode + '\'' +
                ", retInfo='" + retInfo + '\'' +
                '}';
    }
}
