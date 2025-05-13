-- Insert sample authors
INSERT INTO AUTHORS (ID, NAME, BIRTH_DATE, BIOGRAPHY, NATIONALITY) VALUES 
(1, 'Jane Austen', '1775-12-16', 'Jane Austen was an English novelist known primarily for her six major novels, which interpret, critique and comment upon the British landed gentry at the end of the 18th century.', 'British'),
(2, 'George Orwell', '1903-06-25', 'George Orwell was an English novelist, essayist, journalist and critic. His work is characterized by lucid prose, biting social criticism, opposition to totalitarianism, and outspoken support of democratic socialism.', 'British'),
(3, 'J.K. Rowling', '1965-07-31', 'J.K. Rowling is a British author, philanthropist, film producer, and screenwriter, best known for writing the Harry Potter fantasy series.', 'British'),
(4, 'Gabriel García Márquez', '1927-03-06', 'Gabriel García Márquez was a Colombian novelist, short-story writer, screenwriter, and journalist, known affectionately as Gabo or Gabito throughout Latin America.', 'Colombian');

-- Insert sample books
INSERT INTO BOOKS (ID, TITLE, DESCRIPTION, PUBLICATION_DATE, ISBN, PAGE_COUNT, AUTHOR_ID) VALUES
(1, 'Pride and Prejudice', 'Pride and Prejudice follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.', '1813-01-28', '9780141439518', 432, 1),
(2, '1984', '1984 is a dystopian novel that examines the consequences of government overreach, totalitarianism, and repressive regimentation of all persons and behaviors within society.', '1949-06-08', '9780451524935', 328, 2),
(3, 'Animal Farm', 'Animal Farm is an allegorical novella reflecting events leading up to the Russian Revolution of 1917 and then on into the Stalinist era of the Soviet Union.', '1945-08-17', '9780451526342', 112, 2),
(4, 'Harry Potter and the Philosopher\'s Stone', 'The first novel in the Harry Potter series, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry.', '1997-06-26', '9780747532743', 223, 3),
(5, 'One Hundred Years of Solitude', 'One Hundred Years of Solitude is the history of the isolated town of Macondo and of the family who founds it, the Buendías. It tells the story of the rise and fall of the mythical town of Macondo through the history of the Buendía family.', '1967-05-30', '9780060883287', 417, 4);