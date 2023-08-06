package com.team1415.soobookbackend.book.domain.port;

import com.team1415.soobookbackend.book.domain.BookDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookFileQueryPort {

    List<BookDetail> retrieveBookDetailList(MultipartFile file);
}
