package com.crud.tasks.trello.client;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class TrelloClient {

    private final RestTemplate restTemplate;

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.app.username}")
    private String trelloUsername;


    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto) {
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/cards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc", trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam("idList", trelloCardDto.getListId())
                .build()
                .encode()
                .toUri();

        return restTemplate.postForObject(url, null, CreatedTrelloCard.class);
    }

    private URI createURL(String trelloApiEndpoint, String trelloUsername, String trelloAppKey,
    String trelloToken, String fields) {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", fields)
                .queryParam("lists", "all")
                .build()
                .encode()
                .toUri();
    }
    private URI createURLMultiParameters(String trelloApiEndpoint, String trelloUsername, MultiValueMap<String, String> param) {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards")
                .queryParams(param)
                .build()
                .encode()
                .toUri();
    }
    public List<TrelloBoardDto> getTrelloBoards() {
        URI url = createURL(trelloApiEndpoint, trelloUsername, trelloAppKey, trelloToken, "name,id");

        /*Map<String, String> parametry = new HashMap<>();
        parametry.put("key", trelloAppKey);
        parametry.put("token", trelloToken);
        parametry.put("fields", "name,id");
        parametry.put("lists", "all");
        MultiValueMap<String, String> param = new MultiValueMap<String, String>() {
            @Override
            public String getFirst(String key) {
                return null;
            }

            @Override
            public void add(String key, String value) {

            }

            @Override
            public void addAll(String key, List<? extends String> values) {

            }

            @Override
            public void addAll(MultiValueMap<String, String> values) {

            }

            @Override
            public void set(String key, String value) {

            }

            @Override
            public void setAll(Map<String, String> values) {

            }

            @Override
            public Map<String, String> toSingleValueMap() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public List<String> get(Object key) {
                return null;
            }

            @Override
            public List<String> put(String key, List<String> value) {
                return null;
            }

            @Override
            public List<String> remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends List<String>> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<List<String>> values() {
                return null;
            }

            @Override
            public Set<Entry<String, List<String>>> entrySet() {
                return null;
            }
        };
        URI url = createURLMultiParameters(trelloApiEndpoint, trelloUsername, parametry);*/



        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);

        return Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());

    }

}