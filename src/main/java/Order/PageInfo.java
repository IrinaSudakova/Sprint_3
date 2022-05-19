package Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageInfo{

	@JsonProperty("total")
	private int total;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("page")
	private int page;
}