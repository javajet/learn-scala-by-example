import random

""" 
OO Cup of Tea

"""


class Flavour:
    """
    Represents the flavour of a drink or type of beverage.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create a Beverage Type

        :param name: name of the beverage
        """
        self.name = name

    def __str__(self):
        """
        A string version of the beverage type

        :return: the name of the beverage
        """
        return self.name


class Water:
    """
    Represents water.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create some water

        :param name: description of the water
        """
        self.name = name

    def __str__(self):
        """
        A string version of this water

        :return: the description of this water
        """
        return self.name


class Milk:
    """
    Represents some milk.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create some milk

        :param name: description of this milk
        """
        self.name = name

    def __str__(self):
        """
        A string version of this milk

        :return: the description of this milk
        """
        return self.name


class Sugar:
    """
    Represents some sugar.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create some sugar

        :param name: the description of this sugar
        """
        self.name = name

    def __str__(self):
        """
        A string version of this sugar

        :return: the description of this sugar
        """
        return self.name


class Drink:
    """
    Represents a drink or beverage to be made

    """

    def __init__(self, beverage_type):
        """
        Create a basic drink with nothing added

        :param beverage_type: the flavour of the drink
        """
        self.ingredients = []
        self.ingredients.append(beverage_type)

    def add_water(self, water):
        """
        Add some water to the drink

        :param water: water to add
        :return: the drink with water added
        """
        self.ingredients.append(water)
        return self

    def add_milk(self, milk):
        """
        Add some milk to the drink

        :param milk: milk to add
        :return: the drink with milk added
        """
        self.ingredients.append(milk)
        return self

    def add_sugar(self, sugar):
        """
        Add some sugar to the drink

        :param sugar: sugar to add
        :return: the drink with sugar added
        """
        self.ingredients.append(sugar)
        return self

    def stir(self):
        """
        Mixes up the drink

        :return: the stirred drink (not shaken)
        """
        random.shuffle(self.ingredients)
        return self

    def __str__(self):
        """
        A string version of this drink

        :return: the description of this drink
        """
        ingredient_names = [str(ingredient) for ingredient in self.ingredients]
        return ', '.join(ingredient_names)


def make_drink(flavour, water, milk, sugar):
    """
    The main process for making a cup of tea
    (algorithm, perhaps?)

    :param flavour: flavour of the drink
    :param water: chief ingredient
    :param milk: add to taste
    :param sugar: optional if desired
    :return: a lovely brew
    """

    return Drink(flavour)\
        .add_water(water)\
        .add_milk(milk)\
        .add_sugar(sugar)\
        .stir()


def main():
    """
    Start the tea-making process.

    Prints the finished drink to the console.

    :return: nothing
    """

    tea_bag = Flavour('Tea')
    hot_water = Water('Hot Water')
    semi_skimmed = Milk('Semi-Skimmed Milk')
    no_sugar = Sugar('No Sugar')

    drink = make_drink(tea_bag, hot_water, semi_skimmed, no_sugar)

    print drink


if __name__ == '__main__':
    main()

