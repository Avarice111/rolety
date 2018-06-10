#include "catch.hpp"

#include <rpn.hpp>

using Catch::Matchers::EndsWith; // see "matchers"

TEST_CASE("Mathematic operations")
{
    rpn test = rpn();
    REQUIRE(test.count("13930 10 +") == 13940);
    REQUIRE((test.count("13930 10 -")) == 13920);
    //(5 + 6 - 3) * 2 / 4  == 4
    REQUIRE(test.count("5 6 + 3 - 2 * 4 /") == 4);

}


TEST_CASE("Error handling")
{
    rpn test = rpn();
    REQUIRE_THROWS_WITH(test.count("10 2 %"), EndsWith("bad token: %"));

    
}

SCENARIO("Exponentiation test")
{
    GIVEN("there are numbers 2, 3 and rpn put_op code '^'")
    {
        rpn test = rpn();
        test.put_op("^",[](auto& s) {
        auto a = s.back(); //zwraca referencje do ostatniego elementu wektora
        s.pop_back(); //usuwa ostatni element wektora
        auto b = s.back();
        s.pop_back();
        auto c = b;
        for (auto i = 1; i<a; i++)
        c*=b;
        s.push_back(c); //dodaje na koncu wektora kopie przekazywanego argumentu
    });
        WHEN("we call count(\"2 3 ^\")")
        {
            //2^3
            int z = test.count("2 3 ^");
            THEN("the result should be 8")
            {
                REQUIRE(z == 8);
            }
        }
    }
}

