package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.Translator;
import com.team1415.soobookbackend.core.book.infrastructure.model.TranslatorPersistenceEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-25T07:42:53+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.9.jar, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class TranslatorPersistenceMapperImpl implements TranslatorPersistenceMapper {

    @Override
    public Translator fromEntityToDomain(TranslatorPersistenceEntity translatorPersistenceEntity) {
        if ( translatorPersistenceEntity == null ) {
            return null;
        }

        Translator.TranslatorBuilder translator = Translator.builder();

        translator.id( translatorPersistenceEntity.getId() );
        translator.name( translatorPersistenceEntity.getName() );
        translator.introduction( translatorPersistenceEntity.getIntroduction() );

        return translator.build();
    }

    @Override
    public List<Translator> fromEntitysToDomains(Set<TranslatorPersistenceEntity> authorPersistenceEntityList) {
        if ( authorPersistenceEntityList == null ) {
            return null;
        }

        List<Translator> list = new ArrayList<Translator>( authorPersistenceEntityList.size() );
        for ( TranslatorPersistenceEntity translatorPersistenceEntity : authorPersistenceEntityList ) {
            list.add( translatorPersistenceEntityToTranslator( translatorPersistenceEntity ) );
        }

        return list;
    }

    protected Translator translatorPersistenceEntityToTranslator(TranslatorPersistenceEntity translatorPersistenceEntity) {
        if ( translatorPersistenceEntity == null ) {
            return null;
        }

        Translator.TranslatorBuilder translator = Translator.builder();

        translator.id( translatorPersistenceEntity.getId() );
        translator.name( translatorPersistenceEntity.getName() );
        translator.introduction( translatorPersistenceEntity.getIntroduction() );

        return translator.build();
    }
}
