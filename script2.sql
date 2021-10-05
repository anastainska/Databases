USE kainska;

SELECT * FROM kainska.user;
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (1134, 3459, "im nastya", "anastasia.kajinska@gmail.com", "+38082344925", "hello @anastainska");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (114, 3419, "im oleg", "oleg@gmail.com", "+38082784925", "haha look @denys");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (987, 163, "comedian", "olena@gmail.com", "+38082349938", "@olena haha");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (11, 98, "i like dogs", "dogslover@gmail.com", "+380987625", "look they are so cute @dogslover");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (92, 32345, "baby queen", "sasha@gmail.com", "+38082312355", "lol haha @sasha");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (936, 349, "hello there", "123@gmail.com", "+380823449251", "@povelitel99");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (0, 0, "lol", "mygmail@gmail.com", "+38082347385", "@333 hi");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (1, 3, "...", "imnothere@gmail.com", "+38082341125", "@lol hiii");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (113, 93284, "hahaha", "dzidzo@gmail.com", "+380823449259", "@dzidzo i love you");
INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES (134, 359, "stepan giga", "stepan.giga@gmail.com", "+38022222222", "@stepangiga im your biggest fan");

SELECT * FROM kainska.security;
INSERT INTO security (nickname, password, user_id) VALUES ("anastainska", "123baby", 1);
INSERT INTO security (nickname, password, user_id) VALUES ("oleg", "olegparol", 2);
INSERT INTO security (nickname, password, user_id) VALUES ("olenababy", "mypassword", 3);
INSERT INTO security (nickname, password, user_id) VALUES ("cheloveck", "password", 4);
INSERT INTO security (nickname, password, user_id) VALUES ("sashathebest", "passwordofsasha", 5);
INSERT INTO security (nickname, password, user_id) VALUES ("table", "miyparol", 6);
INSERT INTO security (nickname, password, user_id) VALUES ("kvitochka", "haha321", 7);
INSERT INTO security (nickname, password, user_id) VALUES ("sonechko", "yasonechkp", 8);
INSERT INTO security (nickname, password, user_id) VALUES ("dzidzo", "dzidzothebest", 9);
INSERT INTO security (nickname, password, user_id) VALUES ("stepangiga", "ilovepizza", 10);

SELECT * FROM kainska.story;
INSERT INTO story (reactions, user_iduser) VALUES ("wow", 1);
INSERT INTO story (reactions, user_iduser) VALUES ("nice", 2);
INSERT INTO story (reactions, user_iduser) VALUES ("cool", 3);
INSERT INTO story (reactions, user_iduser) VALUES ("you look good", 4);
INSERT INTO story (reactions, user_iduser) VALUES ("hooray", 5);
INSERT INTO story (reactions, user_iduser) VALUES ("hahaha thats funny", 6);
INSERT INTO story (reactions, user_iduser) VALUES ("lol", 7);
INSERT INTO story (reactions, user_iduser) VALUES ("ahhaahahah", 8);
INSERT INTO story (reactions, user_iduser) VALUES ("super", 9);
INSERT INTO story (reactions, user_iduser) VALUES ("youre so beautiful", 10);

SELECT * FROM kainska.post;
INSERT INTO post (user_id, text, photo, date_post) VALUES (1, "thats me", "sdlfkvnsl", "2010-10-01 13:10:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (2, "my dog", "sdlfkvl", "2012-10-02 11:00:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (3, "i love this weather", "sdllkndgfssl", "2019-10-03 10:00:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (4, "i love my friends", "sddfmg ", "2009-10-04 19:10:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (5, "haha", "sdlfkng", "2016-10-05 18:00:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (6, "my fav meme", "swerinwl", "2013-10-06 16:01:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (7, "thats my baby", "wpnglk", "2015-10-07 15:10:10.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (8, "i love him sm", "sdlwenls", "2018-11-08 09:00:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (9, "like this book", "sdlxcvb ", "2012-10-09 22:00:00.000");
INSERT INTO post (user_id, text, photo, date_post) VALUES (10, "im so tired", "sdl;ewk;nff", "2006-10-10 20:00:00.000");

SELECT * FROM kainska.photo_post;
INSERT INTO photo_post (photo_link, post_id) VALUES ("sldnsl", 1);
INSERT INTO photo_post (photo_link, post_id) VALUES ("wekfbjwl", 2);
INSERT INTO photo_post (photo_link, post_id) VALUES ("sldnssldns", 3);
INSERT INTO photo_post (photo_link, post_id) VALUES ("alknsfvl", 4);
INSERT INTO photo_post (photo_link, post_id) VALUES ("alnks", 5);
INSERT INTO photo_post (photo_link, post_id) VALUES ("sd;k;vns", 6);
INSERT INTO photo_post (photo_link, post_id) VALUES ("slkvnl", 7);
INSERT INTO photo_post (photo_link, post_id) VALUES ("avlaslk", 8);
INSERT INTO photo_post (photo_link, post_id) VALUES ("sqwork", 9);
INSERT INTO photo_post (photo_link, post_id) VALUES ("x,cvm ,", 10);

SELECT * FROM kainska.message;
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("hello", "2019-11-10 13:00:00.000", "2019-11-11 14:00:00.000", 1);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("hi", "2017-11-10 13:00:00.000", "2019-11-11 14:19:00.000", 2);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("hey", "2010-11-10 13:00:00.000", "2010-12-11 14:00:00.000", 3);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("hey how are you", "2021-09-10 13:00:00.000", "2021-09-11 14:00:00.000", 4;
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("wassup", "2011-11-10 13:00:00.000", "2011-11-11 14:00:00.000", 5);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("are you okay?", "2013-11-10 13:00:00.000", "2014-11-11 14:00:00.000", 6);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("lets see each other", "2012-11-10 13:00:00.000", "2012-11-13 10:00:00.000", 7);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("lol hi", "2011-11-14 13:00:00.000", "2019-11-14 17:10:09.000", 8);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("hello friend", "2017-11-10 13:00:00.000", "2017-11-11 14:00:00.000", 9);
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES ("hi baby", "2018-11-10 13:00:00.000", "2018-11-11 14:00:00.000", 10);

SELECT * FROM kainska.video_post;
INSERT INTO video_post (video_link, post_id) VALUES ("skdjs", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("sglnls", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("weurewrio", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("sn xcv n", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("q;wlwf", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("df;l;", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("qwkhbef", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("sdlfvlfs", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("ssldnls", 1);
INSERT INTO video_post (video_link, post_id) VALUES ("lqekfnklds", 1);

SELECT * FROM kainska.comment;
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("look nice", 1, 1, "2019-12-10 13:03:10.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("thats good", 5, 2, "2019-12-10 13:53:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("yaaas queen", 10, 3, "2019-12-10 17:03:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("lol", 2, 4, "2019-12-10 10:03:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("hey you look good", 9, 5, "2019-12-10 12:03:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("wow queen", 1, 6, "2019-12-10 19:03:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("thats my girl", 6, 7, "2018-12-10 13:03:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("will you be my sugar baby", 18, 8, "2009-12-10 13:03:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("marry me", 19, 9, "2019-10-10 13:03:00.000");
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES ("that looks awful", 20, 10, "2019-08-10 13:03:00.000");

SELECT * FROM kainska.like_comment;
INSERT INTO like_comment (comment_id) VALUES (1);
INSERT INTO like_comment (comment_id) VALUES (2);
INSERT INTO like_comment (comment_id) VALUES (3);
INSERT INTO like_comment (comment_id) VALUES (4);
INSERT INTO like_comment (comment_id) VALUES (5);
INSERT INTO like_comment (comment_id) VALUES (6);
INSERT INTO like_comment (comment_id) VALUES (7);
INSERT INTO like_comment (comment_id) VALUES (8);
INSERT INTO like_comment (comment_id) VALUES (9);
INSERT INTO like_comment (comment_id) VALUES (10);

SELECT * FROM kainska.like_post;
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2008-12-10 14:03:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2011-11-10 01:03:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2013-10-10 04:03:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2012-01-10 03:03:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2019-03-10 20:03:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2005-08-10 22:03:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2021-10-10 23:03:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2019-06-10 11:22:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2014-05-10 20:06:00.000");
INSERT INTO like_post (post_id, time_creation) VALUES (1, "2017-01-10 13:05:00.000");

SELECT * FROM kainska.video_story;
INSERT INTO video_story (story_id, link_video_story) VALUES (1, "ewoihwfoihn");
INSERT INTO video_story (story_id, link_video_story) VALUES (2, "sdkvsd");
INSERT INTO video_story (story_id, link_video_story) VALUES (3, "wlekfnksv");
INSERT INTO video_story (story_id, link_video_story) VALUES (4, "ldknfvlk");
INSERT INTO video_story (story_id, link_video_story) VALUES (5, "qw;kwe");
INSERT INTO video_story (story_id, link_video_story) VALUES (6, "wlknlv");
INSERT INTO video_story (story_id, link_video_story) VALUES (7, "ldljfnvlk");
INSERT INTO video_story (story_id, link_video_story) VALUES (8, "wnflvs");
INSERT INTO video_story (story_id, link_video_story) VALUES (9, "wlejflsd");
INSERT INTO video_story (story_id, link_video_story) VALUES (10, "wlenlksvf");

SELECT * FROM kainska.photo_story;
INSERT INTO photo_story (story_id, link_photo_story) VALUES (1, "ekrgbjklerbg");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (2, "e;kfmnkefn");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (3, "sqewknkflwnke");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (4, "lkdknvvklw");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (5, "ldknvldnkvlsdn");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (6, ";wekfm;kwvn");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (7, "qeufwkvjb");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (8, "sldsldvndsklv");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (9, "sldj");
INSERT INTO photo_story (story_id, link_photo_story) VALUES (10, "sdvbdsjkbvkjd");