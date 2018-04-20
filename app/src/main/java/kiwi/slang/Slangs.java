package kiwi.slang;

import java.util.Random;

public class Slangs {

    private String[] slangs = {
            "Ads – tv commercials, advertisments",
            "Anklebiter – toddler, small child",
            "Aotearoa – Maori name for New Zealand meaning land of the long white cloud",
            "Arvo – afternoon",
            "Bach – holiday home",
            "Banger – sausage, as in bangers and mash",
            "Barbie – barbecue",
            "Big smoke – large town or city",
            "Bit of dag – hard case, comedian, person with character",
            "Bitser – mongrel dog",
            "Bloke – man",
            "Brickie – bricklayer",
            "Brown eye – to flash your naked butt at someone",
            "Boy-racer – name given to a young man who drives a fast car with a loud stereo",
            "Bring a plate – means bring a dish of food to share",
            "Bugger – damn!",
            "Bungy – kiwi slang for elastic strap, as in Bungy Jumping",
            "Caravan – mobile home that you tow behind your car",
            "Cardi – cardigan",
            "Cast – immobilised, unable to get to your feet",
            "Cheers – thanks",
            "Cheerio – goodbye",
            "Cheerio – name for a cocktail sausage",
            "Chocka – full, overflowing",
            "Chook – chicken",
            "Chick – slang word for woman/female",
            "Chips – deep fried slices of potato but much thicker than a french fry",
            "Chippy – builder, carpenter",
            "Chrissy pressies – Christmas presents",
            "Chuddy – chewing gum",
            "Chunder – vomit, throw up",
            "Cockie – farmer",
            "Cotton buds – Q-tips",
            "Creek – small stream",
            "Crib – bach,",
            "Cuppa – cup of tea, as in cuppa tea",
            "Cuz – cousin, family",
            "De facto – name used for a couple who are not married but are living together",
            "Ding – small dent in a vehicle",
            "Dole – unemployment benefit",
            "Dodgy – bad, unreliable, not good",
            "Down the gurgler – failed plan",
            "Drongo – stupid fool, idiot",
            "Drop your gear – take your clothes off, get undressed",
            "Dunny – toilet, bathroom, lavatory",
            "Duvet – quilt, doona",
            "Ear bashing – someone talking incessantly",
            "Entree – appetizer, hors d’oeurve",
            "Fizz Boat – small power boat",
            "Fizzy drink – soda pop",
            "Flannel – wash cloth, face cloth",
            "Flat – apartment, name for rental accommodation that is shared",
            "Flicks – movies, picture theatre",
            "Flog – steal, rob",
            "Footie – rugby union or league, as in “going to watch the footie”",
            "Full tit – going very fast, using all your power, as in “he was running full tit”",
            "G’day – universal kiwi greeting, also spelled gidday",
            "Get the willies – overcome with trepidation",
            "Going bush – take a break, become reclusive",
            "Good on ya, mate! – congratulations, well done, proud of someone",
            "Good as gold – feeling good, not a problem, yes",
            "Greasies – fish and chips",
            "Gumboots or gummies – rubber boots, wellingtons",
            "Handle – pint of beer",
            "Happy as larry – very happy",
            "Hard case – amusing, funny person",
            "Hard yakka – hard work",
            "Hollywood – to fake or exaggerate an injury on the sportsfield",
            "Home and hosed – safe, successfully finished, completed,",
            "Hoon – Young adult driving fast",
            "Hosing down – heavy rain, raining heavily",
            "Hottie – hot water bottle",
            "How’s it going mate? – kiwi greeting",
            "Iceblock – popsicle, Ice Stick",
            "Jandal – thongs, sandals,flip-flops,",
            "Judder bar – speed bump",
            "Jumper – sweater, jersey",
            "Kiwi – New Zealander",
            "Kiwifruit – Brown furry skinned fruit, Zespri, Chinese Gooseberry",
            "Kick the bucket – die",
            "Knackered – exhausted, tired, lethargic",
            "Knuckle sandwhich – a fist in the teeth, punch in the mouth",
            "Laughing gear – mouth, as in wrap your laughing gear around this,",
            "L&P – Fizzy soda water",
            "Lift – elevator",
            "Lolly – candy",
            "Loo – bathroom, toilet",
            "Long drop – outdoor toilet, hole in ground",
            "Lurgy – flu",
            "Mad as a meat axe – very angry or crazy",
            "Main – primary dish of a meal",
            "Maori – indigenous people of New Zealand",
            "Mate – buddy",
            "Motorway – freeway",
            "Naff off – go away, get lost, leave me alone",
            "Nana – grandmother, grandma",
            "Nappy – diaper",
            "North Cape to the Bluff – from one end of New Zealand to the other",
            "OE – Overseas Experience, many students go on their OE after finishing university, see the world",
            "Offsider – an assistant, someones friend, as in “we saw him and his offsider going down the road”",
            "Old bomb – old car",
            "Oldies – parents",
            "On the never never – paying for something using layby, not paying straight away",
            "Open slather – a free-for-all",
            "Pack a sad – bad mood, morose, ill-humoured, broken , as in “she packed a sad”",
            "Pakeha – non-Maori person",
            "Panel beater – auto repair shop, panel shop",
            "Pav – pavlova, dessert usually topped with kiwifruit and cream",
            "Perve – to stare",
            "Petrol – gasoline, gas",
            "Piece-of-piss – easy, not hard to do, as in “didn’t take me long to do, it was a piece of piss”",
            "Pikelet – small pancake usually had with jam and whipped cream",
            "Piker – someone who gives up easy, slacker",
            "Pinky – little finger",
            "Piss around – waste time, muck around",
            "Pisshead – someone who drinks a lot of alcohol, heavy drinker",
            "Piss up – party, social gathering, excuse for drinking alcohol",
            "Pissed off – annoyed, angry, upset",
            "Plonk – cheap liquor, cheap wine",
            "Pong – bad smell, stink",
            "Postal code – zip code",
            "Pram – baby stroller, baby pushchair",
            "Pressie – present",
            "Pub – bar or hotel that serves liquor",
            "Pudding – dessert",
            "Pushing up daisies – dead and buried",
            "Quack – Medical doctor",
            "Randy – horny, wanting sex",
            "Rark up – telling somebody off",
            "Rattle your dags – hurry up, get moving",
            "Rellies – relatives, family",
            "Root – have sex, get sex",
            "Ropeable – very angry",
            "Ring – to telephone somebody, as in “I’ll give you a ring”",
            "Rubbish – garbage, trash",
            "Rust bucket – decrepit motor car",
            "Scarce as hens teeth – very scarce, rare",
            "Scarfie – university student",
            "Scull – consume, drink quickly",
            "Scroggin – trampers high energy food including dried fruits, chocolate",
            "Serviette – paper napkin",
            "Shandy – drink made with lemonade and beer",
            "Shark and taties – fish and chips",
            "Sheila – slang for woman/female",
            "Shit a brick – exclamation of surprise or annoyance",
            "Shoot through – to leave suddenly",
            "Shout – to treat, to buy something for someone, as in “lunch is my shout”",
            "Sickie – to take a day off work or school because you are sick",
            "Skite – to boast, boasting, bragging",
            "Snarler – sausage",
            "Sook – cry baby, wimp",
            "Sparkie – electrician",
            "Sparrow fart – very early in the morning, sunrise",
            "Sprog – child",
            "Spud – potato",
            "Squiz – take a quick look",
            "Steinie – bottle of Steinlager, brand lager",
            "Strapped for cash – low on cash, no money",
            "Stubby – small glass bottle of beer",
            "Sunday driver – someone who drives very slow",
            "Sunnies – sunglasses",
            "Ta – thanks",
            "Take-aways – food to be taken away and eaten, fast food outlet",
            "Tea – evening meal, dinner",
            "Tights – pantyhose",
            "Tiki tour – scenic tour, take the long route",
            "Togs – swimsuit, bathing costume",
            "Torch – flashlight",
            "Tramping – hiking",
            "Twink – white-out",
            "Up the duff – pregnant",
            "Ute – small pickup truck",
            "Veges – vegetables",
            "Wally – clown, silly person",
            "Whinge – complain, moan",
            "Wobbly – to have a tantrum",
            "Wop-wops – situated off the beaten track, out of the way location",
            "Yack – to have a conversation with a friend, to talk",};


     String getSlangs() {
        Random slangGenerator = new Random();
        int randomNumber = slangGenerator.nextInt(slangs.length);
        return slangs[randomNumber];
    }
}