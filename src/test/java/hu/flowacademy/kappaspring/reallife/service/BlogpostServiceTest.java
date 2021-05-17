package hu.flowacademy.kappaspring.reallife.service;

import hu.flowacademy.kappaspring.reallife.exception.ValidationException;
import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogpostServiceTest {

    @InjectMocks
    private BlogpostService blogpostService;

    @Mock
    private BlogpostRepository blogpostRepository;

    @Test
    public void testSave() {
        Blogpost expectedBlogpost = givenValidBlogpost();

        Blogpost actualBlogpost = whenSavingBlogpost(expectedBlogpost);

        thenResultsShouldMatch(expectedBlogpost, actualBlogpost);
    }

    @Test
    public void testSaveValidateFailing() {
        assertThrows(ValidationException.class,
                () -> blogpostService.save(
                        giveEmptyBlogpost()
                ));
        assertThrows(ValidationException.class,
                () -> blogpostService.save(
                        giveBlogpostWithoutDescription()
                ));
        assertThrows(ValidationException.class,
                () -> blogpostService.save(
                        giveBlogpostWithoutPublisher()
                ));
    }

    @Test
    public void testUpdate() {
        String expectedId = UUID.randomUUID().toString();
        Blogpost expectedBlogpost = givenValidBlogpost();

        Blogpost actualBlogpost = whenUpdatingBlogpost(expectedId, expectedBlogpost);

        thenResultsShouldMatch(expectedId, expectedBlogpost, actualBlogpost);
    }

    @Test
    public void testUpdateValidateFailing() {
        assertThrows(ValidationException.class,
                () -> blogpostService.update("invalid format", giveEmptyBlogpost())
        );
    }

    private Blogpost whenUpdatingBlogpost(String expectedId, Blogpost expectedBlogpost) {
        when(blogpostRepository.update(any()))
                .thenReturn(expectedBlogpost.toBuilder()
                        .id(expectedId)
                        .updatedAt(LocalDateTime.now())
                        .build());

        return blogpostService.update(expectedId,
                expectedBlogpost
        );
    }

    private Blogpost givenValidBlogpost() {
        return Blogpost.builder()
                .title("valami")
                .description("valami mas")
                .publisher("asdf")
                .build();
    }

    private Blogpost giveBlogpostWithoutPublisher() {
        return Blogpost.builder()
                .title("title")
                .description("desc")
                .build();
    }

    private Blogpost giveBlogpostWithoutDescription() {
        return Blogpost.builder()
                .title("title")
                .build();
    }

    private Blogpost giveEmptyBlogpost() {
        return Blogpost.builder().build();
    }

    private Blogpost whenSavingBlogpost(Blogpost expectedBlogpost) {
        when(blogpostRepository.save(any()))
                .thenReturn(
                        expectedBlogpost
                                .toBuilder()
                                .id(UUID.randomUUID().toString())
                                .createdAt(LocalDateTime.now())
                                .build()
                );

        return blogpostService.save(
                expectedBlogpost
        );
    }

    private void thenResultsShouldMatch(Blogpost expectedBlogpost, Blogpost actualBlogpost) {
        thenResultTitleDescriptionAndPublisherShouldMatch(expectedBlogpost, actualBlogpost);
        assertNotNull(actualBlogpost.getId());
        assertNotNull(actualBlogpost.getCreatedAt());
    }

    private void thenResultsShouldMatch(String expectedId, Blogpost expectedBlogpost, Blogpost actualBlogpost) {
        thenResultTitleDescriptionAndPublisherShouldMatch(expectedBlogpost, actualBlogpost);
        assertEquals(expectedId, actualBlogpost.getId());
        assertNotNull(actualBlogpost.getUpdatedAt());
    }

    private void thenResultTitleDescriptionAndPublisherShouldMatch(Blogpost expectedBlogpost, Blogpost actualBlogpost) {
        assertEquals(expectedBlogpost.getTitle(),
                actualBlogpost.getTitle());
        assertEquals(expectedBlogpost.getDescription(),
                actualBlogpost.getDescription());
        assertEquals(expectedBlogpost.getPublisher(),
                actualBlogpost.getPublisher());
    }

}