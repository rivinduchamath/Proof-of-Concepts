package ilabs.cog.entitylistener.service;

import ilabs.cog.entitylistener.entities.Author;
import ilabs.cog.entitylistener.entities.Ebook;
import ilabs.cog.entitylistener.entities.Paperback;
import ilabs.cog.entitylistener.repo.AuthorRepository;
import ilabs.cog.entitylistener.repo.EbookRepository;
import ilabs.cog.entitylistener.repo.PaperbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;
    private final PaperbackRepository paperbackRepository;
    private final EbookRepository ebookRepository;
    @Transactional
    public void persistAuthorWithBooks() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Alicia Tom");
        author.setAge(38);
        author.setGenre("Anthology");

        Paperback paperback = new Paperback();
        paperback.setIsbn("002-AT");
        paperback.setTitle("The beatles anthology");
        paperback.setSizeIn("7.5 x 1.3 x 9.2");
        paperback.setWeightLbs("2.7");
        paperback.setAuthor(author);

        Ebook ebook = new Ebook();
        ebook.setId(3L);
        ebook.setIsbn("003-AT");
        ebook.setTitle("Anthology myths");
        ebook.setFormat("kindle11");
        ebook.setAuthor(author);

        authorRepository.save(author);
        paperbackRepository.save(paperback);
        ebookRepository.save(ebook);
    }
    @Transactional
    public void fetchAndRemovePaperback() {
        Paperback paperback = paperbackRepository.findByTitle("The beatles anthology");
        paperbackRepository.delete(paperback);
    }
    @Transactional
    public void fetchAndRemoveEbook() {
        Ebook ebook = ebookRepository.findByTitle("Anthology myths");
        ebookRepository.delete(ebook);
    }
}