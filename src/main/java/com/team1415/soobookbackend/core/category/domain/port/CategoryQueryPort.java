package com.team1415.soobookbackend.core.category.domain.port;

import com.team1415.soobookbackend.core.category.domain.Category;
import com.team1415.soobookbackend.common.annotation.Port;
import java.util.List;

@Port
public interface CategoryQueryPort {

    List<Category> findAll();
}
