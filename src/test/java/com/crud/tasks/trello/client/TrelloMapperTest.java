package com.crud.tasks.trello.client;
import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperTest {
   TrelloMapper mapper = new TrelloMapper();

    @Test
    public void MapToBoardsTest(){
        //Given
       List<TrelloBoardDto> listaInput = new ArrayList<>();
        List<TrelloListDto> trelloListtDto = new ArrayList<>();
        trelloListtDto.add(new TrelloListDto("1", "lista", false));
       listaInput.add(new TrelloBoardDto("123", "Pierwsza", trelloListtDto));
        listaInput.add(new TrelloBoardDto("1234", "Druga", trelloListtDto));
        listaInput.add(new TrelloBoardDto("12345", "Trzecia", trelloListtDto));
        //When
        List<TrelloBoard> result = mapper.mapToBoards(listaInput);
        //Then
        assertEquals(3, result.size());
        assertEquals("123", result.get(0).getId());
    }

    @Test
    public void MapToBoardsDtoTest(){
        //Given
        List<TrelloBoard> listaInput = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "lista", false));
        listaInput.add(new TrelloBoard("123", "pierwsza", trelloList));
        listaInput.add(new TrelloBoard("1234", "Druga", trelloList));
        listaInput.add(new TrelloBoard("12345", "Trzecia", trelloList));
        //When
        List<TrelloBoardDto> result = mapper.mapToBoardsDto(listaInput);
        //Then
        assertEquals(3, result.size());
        assertEquals("12345", result.get(2).getId());
    }
    @Test
    public void MapToListDtoTest(){
        //Given

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "lista", false));
        trelloList.add(new TrelloList("2", "lista druga", true));
        //When
        List<TrelloListDto> result = mapper.mapToListDto(trelloList);
        //Then
        assertEquals(2, result.size());
        assertEquals("1", result.get(0).getId());
    }
    @Test
    public void MapToListTest(){
        //Given

        List<TrelloListDto> trelloList = new ArrayList<>();
        trelloList.add(new TrelloListDto("1", "lista", false));
        trelloList.add(new TrelloListDto("2", "lista druga", true));
        //When
        List<TrelloList> result = mapper.mapToList(trelloList);
        //Then
        assertEquals(2, result.size());
        assertEquals("1", result.get(0).getId());
    }

    @Test
    public void MapToCardDtoTest(){
        //Given
        TrelloCard trelloCard = new TrelloCard("jeden", "jeden des",
                "pos jeden", "listId jeden");
        //When
        TrelloCardDto result = mapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("jeden", result.getName());
        assertEquals("pos jeden", result.getPos());
    }

    @Test
    public void MapToCardTest(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("jeden Dto", "jeden des Dto",
                "pos jeden Dto", "listId jeden Dto");
        //When
        TrelloCard result = mapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("jeden Dto", result.getName());
        assertEquals("listId jeden Dto", result.getListId());
    }

}
