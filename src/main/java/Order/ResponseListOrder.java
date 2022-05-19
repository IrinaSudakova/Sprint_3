package Order;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseListOrder{

	@JsonProperty("pageInfo")
	private PageInfo pageInfo;

	@JsonProperty("availableStations")
	private List<AvailableStationsItem> availableStations;

	@JsonProperty("orders")
	private List<OrdersItem> orders;
}