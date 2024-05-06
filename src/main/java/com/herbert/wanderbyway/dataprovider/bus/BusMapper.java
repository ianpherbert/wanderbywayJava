package com.herbert.wanderbyway.dataprovider.bus;

import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchItemType;
import com.herbert.wanderbyway.dataprovider.bus.entity.Location;
import com.herbert.wanderbyway.utils.StringUtils;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
abstract class BusMapper {
    SearchItem toSearchItem(Location location){
        return new SearchItem(
                location.getId(),
                location.getName(),
                StringUtils.removeAccentsAndSpecialCharacters(location.getName()),
                SearchItemType.BUS_STATION,
                location.getStops().stream().map(stop -> new SearchItem(
                        stop.getId(),
                        stop.getName(),
                        StringUtils.removeAccentsAndSpecialCharacters(stop.getName()),
                        SearchItemType.BUS_STATION,
                        null,
                        location.getCountryCode()
                )).toList(),
                location.getCountryCode()
        );
    }

    List<SearchItem> toSearchItems(List<Location> locations){
        return locations.stream().map(this::toSearchItem).toList();
    }
}
