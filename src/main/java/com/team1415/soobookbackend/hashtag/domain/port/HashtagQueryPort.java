package com.team1415.soobookbackend.hashtag.domain.port;

import com.team1415.soobookbackend.common.annotation.Port;
import com.team1415.soobookbackend.hashtag.domain.Hashtag;

import java.util.List;

@Port
public interface HashtagQueryPort {

    List<Hashtag> retrieveHashtagListByCategoryId(Long categoryId);
}
