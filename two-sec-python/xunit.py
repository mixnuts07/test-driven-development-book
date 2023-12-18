class TestCase:
    def __init__(self, name):
        self.name = name
    def setUp(self):
        pass
    def run(self):
        self.setUp()
        method = getattr(self, self.name)
        method()

class WasRun(TestCase):
    def setUp(self):
        self.wasSetUp = None
    def testMethod(self):
        self.wasRun = 1

class TestCaseTest(TestCase):
    def setUp(self):
        self.test = WasRun("testMethod")
    def testRunning(self):
        self.test.run()
        assert (self.test.wasRun)
    def testSetUP(self):
        self.test.run()
        assert (self.test.wasSetUp)

TestCaseTest("testRunning").run()
TestCaseTest("testSetUp").run()