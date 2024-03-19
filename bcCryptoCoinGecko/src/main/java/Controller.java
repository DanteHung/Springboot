import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/crypto/coingecko/api/v1")
public class CryptoController {

    @Value("${coingecko.api.url}")
    private String coingeckoApiUrl;

    @GetMapping("/coins")
    public ResponseEntity<String> getCoinData() {
        WebClient webClient = WebClient.builder().baseUrl(coingeckoApiUrl).build();
        String currency = "usd";
        String ids = "bitcoin,ethereum";

        String url = "/coins/markets?vs_currency=" + currency + "&ids=" + ids;

        return webClient.get().uri(url).retrieve().toEntity(String.class).block();
    }
}