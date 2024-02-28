package justdoit.api.feign.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

/**
 * DummyApiResponse
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Schema(description = "dummy response")
@Getter
public class DummyApiResponse {

    @Schema(description = "id", example = "1")
    private Integer id;

    @Schema(description = "title", example = "title")
    private String title;

    @Schema(description = "price", example = "price")
    private String price;

    @Schema(description = "category", example = "category")
    private String category;

    @Schema(description = "description", example = "description")
    private String description;

    @Schema(description = "image", example = "image")
    private String image;
}
