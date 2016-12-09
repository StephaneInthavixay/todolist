-- CategoryDaoTest
-- testFindCategory
-- ID = 1L
INSERT INTO category(name) VALUES('testFindCategoryNameDB');

-- testUpdateCategoryHasNameChanged
-- ID = 2L
INSERT INTO category(name) VALUES('testUpdateCategoryChangedNameDB');

-- testUpdateCategoryHasRightName
-- ID = 3L
INSERT INTO category(name) VALUES('testUpdateCategoryRightNameDB');

-- TaskDaoTest
-- testFindableByLabel
-- ID_TASK = 1L
INSERT INTO task(label) VALUES('testFindableLabelDB');

-- TaskDaoTest
-- testTaskIsFindableByIdUser
-- ID_TASK = 2L
INSERT INTO task(label, id_user) VALUES('testFindableLabelDB', 1);

-- TaskDaoTest
-- testTaskIsFindableByEndingDate
-- ID_TASK = 3L
INSERT INTO task(label, endingDate) VALUES('testFindableLabelDB', '2000-12-12');

-- TaskDaoTest
-- testTaskIsFindableAndDone
-- ID_TASK = 4L
INSERT INTO task(label, endingDate) VALUES('testFindableLabelDB', '2000-12-12');

-- TaskDaoTest
-- testTaskIsFindableByEndingDateBetweenFirstPrevisionalDateAndSecondPrevisionalDate
-- ID_TASK = 5L
INSERT INTO task(label, firstPrevisionalDate, secondPrevisionalDate, endingDate) VALUES('testFindableLabelDB', '2000-12-10', '2000-12-12', '2000-12-11');

-- TaskDaoTest
-- testTaskIsFindableAndDoneBetweenFirstPrevisionalDateAndSecondPrevisionalDate
-- ID_TASK = 6L
INSERT INTO task(label, firstPrevisionalDate, secondPrevisionalDate, endingDate) VALUES('testFindableLabelDB', '2000-12-10', '2000-12-12', '2000-12-11');

-- TaskDaoTest
-- testTaskIsFindableByIdUserAndDoneBetweenFirstPrevisionalDateAndSecondPrevisionalDate
-- ID_TASK = 7L
INSERT INTO task(label, firstPrevisionalDate, secondPrevisionalDate, endingDate, id_user) VALUES('testFindableLabelDB', '2000-12-10', '2000-12-12', '2000-12-11', 1);

-- testListTasksForGivenUserAndCategory
-- ID_USER = 1L
INSERT INTO users(name, USER_TYPE) VALUES('testUserDB', 'USER_FREE');

-- ID_CATEGORY = 4L
INSERT INTO category(name) VALUES('testCategoryDB');
