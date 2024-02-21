package justdoit.api.payload;

import justdoit.api.exception.ExceptionType;
import justdoit.api.exception.JandbException;

/**
 * ResponseFactory
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public class ResponseFactory {

    /**
     * <pre>
     *    성공 응답을 넘겨준다.
     * </pre>
     * @return Response<D>
     * @param <D> Object Type
     */
    public static <D> Response<D> createSuccess() {
        return createSuccess(null, ExceptionType.SUCCESS.getCode(), ExceptionType.SUCCESS.getMessage());
    }

    /**
     * <pre>
     *     요청한 결과를 포함한 성공 응답을 넘겨준다.
     * </pre>
     * @param data 요청한 결과 data
     * @return Response<D>
     * @param <D> Object Type
     */
    public static <D> Response<D> createSuccess(D data) {
        return createSuccess(data, ExceptionType.SUCCESS.getCode(), ExceptionType.SUCCESS.getMessage());
    }

    /**
     * <pre>
     *    성공 응답을 넘겨준다.
     * </pre>
     * @param data 요청한 결과 data
     * @param code 상태 코드
     * @param message 상태 메세지
     * @return Response<D>
     * @param <D> Object Type
     */
    public static <D> Response<D> createSuccess(D data, String code, String message) {
        Response<D> response = new Response<>();
        response.setStatus(ExceptionType.SUCCESS.getHttpStatus().value());
        response.setCode(code);
        response.setMessage(message);
        if(data != null) response.setData(data);

        return response;
    }

    /**
     * <pre>
     *    실패 응답을 넘겨준다.
     * </pre>
     * @param e Exception
     * @return Response<D>
     * @param <D> Object type
     */
    public static <D> Response<D> createError(Exception e) {

        return createError(null, e);
    }

    /**
     * <pre>
     *    실패 응답을 넘겨준다.
     * </pre>
     * @param data 넘겨줄 데이터
     * @param e Exception
     * @return Response<D>
     * @param <D> Object type
     */
    public static <D> Response<D> createError(D data, Exception e) {
        Response<D> response = new Response<>();

        if(e instanceof JandbException je){
            response.setCode(je.getCode());
            response.setMessage(je.getMessage());
            response.setStatus(je.getHttpStatus().value());
        }else{
            response.setCode(ExceptionType.UNKNOWN.getCode());
            response.setMessage(e.getMessage());
            response.setStatus(ExceptionType.UNKNOWN.getHttpStatus().value());
        }

        if(data != null) response.setData(data);

        return response;
    }
}
