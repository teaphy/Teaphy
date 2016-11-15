package bean;

/**
 * Created by Administrator
 * on 2016/6/13.
 */
public class Result<T> extends BaseResult {
    T result;

    public Result() {
    }

    public Result(T result) {
        this.result = result;
    }

    public Result(String retCode, String retInfo, T result) {
        super(retCode, retInfo);
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                '}';
    }
}
