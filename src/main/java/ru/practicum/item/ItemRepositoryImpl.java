package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    protected List<Item> items;

    @Override
    public List<Item> findByUserId(long userId) {

        return items
                .stream()
                .filter(item -> item.getUserId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public Item save(long userId, Item item) {
        item.setUserId(userId);
        items.add(item);
        return items.stream().filter(item1 -> Objects.equals(item1.getId(), item.getId())).collect(Collectors.toList()).get(0);
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        Item itemForDelete = items
                .stream()
                .filter(item -> item.getUserId() == userId && item.getId() == itemId)
                .collect(Collectors.toList()).get(0);
        items.remove(itemForDelete);

    }
}
