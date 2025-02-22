package cn.tedu.baking.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用来封装响应的信息结果集
 */
@Data
@AllArgsConstructor
public class JsonResult {
    /**
     * 响应状态码(已经提前定义好了)
     */
    private Integer code;
    /**
     * 状态码的含义(比如用户名被占用等)
     */
    private String msg;
    /**
     * 服务端需要给客户端返回的具体数据(不一定有值,但是返回话,可能是任意类型,看具体业务)
     */
    private Object data;

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public JsonResult(StatusCode statusCode,Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    /**
     *  SUCCESS成功的状态下,并且需要返回对象时
     * @param obj
     */
    private JsonResult(Object obj){
        this.code = StatusCode.SUCCESS.getCode();
        this.msg =  StatusCode.SUCCESS.getMsg();
        this.data = obj;
    }
    public static JsonResult ok(Object obj){
        return new JsonResult(obj);
    }
    /**
     *  SUCCESS成功的状态下,不需要返回对象 只需要包含有码和信息
     */
    private JsonResult(){
        this.code = StatusCode.SUCCESS.getCode();
        this.msg =  StatusCode.SUCCESS.getMsg();
    }
    public static JsonResult ok(){
        return new JsonResult();
    }

}
