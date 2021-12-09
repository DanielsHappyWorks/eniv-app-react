package com.envi.api.enviapi;
import com.envi.api.enviapi.model.Comments;
import com.envi.api.enviapi.model.Data;
import com.envi.api.enviapi.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DataService dataService) {

        return args -> {
            Data dataA = Data.builder()
                    .author("Dan Roth")
                    .name("Gradistea, Romania")
                    .latitude(44.23333)
                    .longitude(27.21667)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 7000)
                    .description("This is a place in Romania, given by a generator")
                    .build();
            dataA = dataService.save(dataA);
            dataService.addComment(dataA.getId(), Comments.builder().name("Dan Roth").comment("This place is randomly generated").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Dood Dood").comment("Dooooooood!").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Random Text").comment("Now is the winter of our discontent\n Made glorious summer by this sun of York").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Random Numbers").comment("1296398019\n" +
                    "9323625795\n" +
                    "0677504196\n" +
                    "8797292955\n" +
                    "4552780833\n" +
                    "1576389018\n" +
                    "1367212155\n" +
                    "6940781486\n" +
                    "9416805751\n" +
                    "7763144239").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Dan Roth").comment("Data is hard to generate well").build());

            Data dataB = Data.builder()
                    .author("Dan Roth")
                    .name("Gradistea, Romania V2")
                    .latitude(44.23333)
                    .longitude(27.21667)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 6000)
                    .description("This is a place in Romania again")
                    .build();
            dataB = dataService.save(dataB);
            dataService.addComment(dataA.getId(), Comments.builder().name("Roth Roth").comment("... Same date really?").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Dan Dan").comment("... Not creative!").build());


            Data dataC = Data.builder()
                    .author("Alice Pleasance Hargreaves")
                    .name("Wonderland")
                    .latitude(33.8121)
                    .longitude(117.9190)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 1000)
                    .description("What a wonderful place")
                    .build();
            dataC = dataService.save(dataC);
            dataService.addComment(dataA.getId(), Comments.builder().name("Mad Hatter").comment("Tis place is good fun.").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("The Rabbit").comment("Oh no were going to be late").build());

            Data dataD = Data.builder()
                    .author("Dan Roth")
                    .name("Gradistea, Romania V3")
                    .latitude(44.23333)
                    .longitude(27.21667)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 10000)
                    .description("Its here again")
                    .build();
            dataD = dataService.save(dataD);
            dataService.addComment(dataA.getId(), Comments.builder().name("Mad Hatter").comment("Such repetition, much WOW!").build());

            Data dataE = Data.builder()
                    .author("Luna Lovegood")
                    .name("Hogwarts - School of magic")
                    .latitude(51.5319)
                    .longitude(0.1235)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 3000)
                    .description("This is not a place in Romania, given by a generator")
                    .build();
            dataE = dataService.save(dataE);
            dataService.addComment(dataA.getId(), Comments.builder().name("Lord V").comment("Why wont Harry just leave me alone!").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Harry Potter").comment("Died nearly once a year, 0/10 not recommended!").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Hermione Granger").comment("Got a 112 on an exam, Now this is studying!").build());

            Data dataF = Data.builder()
                    .author("Big Ben")
                    .name("The Clock Tower")
                    .latitude(51.5007)
                    .longitude(0.1246)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 3000)
                    .description("The biggest of all the big clocks, just ticking away")
                    .build();
            dataF = dataService.save(dataF);
            dataService.addComment(dataA.getId(), Comments.builder().name("Big Ben").comment("The best uncle ben!").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Uncle Ben").comment("No It is I, the best uncle ben!").build());

            Data dataG = Data.builder()
                    .author("John Doe")
                    .name("Lost Somewhere")
                    .latitude(19.0643)
                    .longitude(13.5437)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 3000)
                    .description("In the Sahel dessert there was a John Doe")
                    .build();
            dataG = dataService.save(dataG);
            dataService.addComment(dataA.getId(), Comments.builder().name("John Doe").comment("Im Lost").build());
            dataService.addComment(dataA.getId(), Comments.builder().name("Bob The Builder").comment("We cant fix this!").build());


            Data dataH = Data.builder()
                    .author("Dan Roth")
                    .name("No Comments")
                    .latitude(48.8566)
                    .longitude(2.3522)
                    .lastDate(System.currentTimeMillis()/1000L)
                    .nextDate(System.currentTimeMillis()/1000L + 3000)
                    .description("No comments have been added to this, map should show paris?")
                    .build();
            dataH = dataService.save(dataH);

            dataService.findAll().forEach(course -> log.info("Preloaded " + course));
        };
    }
}