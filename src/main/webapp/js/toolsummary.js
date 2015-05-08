/*----------------------------------------------------------------------*/
/* KO Page Binding                                                      */
/*----------------------------------------------------------------------*/
$(document).ready(function() {

    $("select.searchtool").select2();

    $.ajaxSetup({ cache: false });

    //  create the model
    var viewModel = new ToolingInventoryViewModel();

    //  bind model to the html
    ko.applyBindings( viewModel );

    viewModel.initialize ( ) ;

    ko.bindingHandlers.select2 = {
        init: function(element, valueAccessor) {
            var options = ko.toJS(valueAccessor()) || {};
            setTimeout(function() {
                $(element).select2(options);
            }, 0);
        }
    } ;

});


/*----------------------------------------------------------------------*/
/* View Model
 /*----------------------------------------------------------------------*/
function ToolingInventoryViewModel() {

    // The assignment
    var self = this;

    // The Data
    self.toolsheaders = [
        {title: 'Tooling No'},
        {title: 'Product Group'},
        {title: 'Tooling Name'},
        {title: 'Tool Size'},
        {title: 'Pattern / Tooling / Die Material'},
        {title: '# of Cavity'},
        {title: 'Qty'},
        {title: 'Core Box Material'},
        {title: '# of Cavity'},
        {title: 'Qty'},
        {title: 'Match Plate / Base Plate Material'},
        {title: 'Qty'},
        {title: 'Available At'},
        {title: 'Tooling Cost'},
        {title: 'Actions'}
    ];

    self.tools = ko.observableArray([]);

    self.vendors = ko.observableArray([]) ;

    self.vendorsids = ko.observableArray([]) ;

    self.selectedVendor = ko.observable('') ;

    self.query = ko.observable('');

    self.toolsdisplayed =  ko.observableArray([]);
    this.pageNumber=ko.observable(0);
    // the buttons
    self.updateButton = ko.observable ( true ) ;

    var toolTable = [];


    // The Functions
    self.getToolsInformation = function ( ) {
        $.getJSON("/tis/tools/all", function(resultData) {
            ko.mapping.fromJS(resultData, {} ,self.tools);
            ko.mapping.fromJS(resultData, {} ,self.toolsdisplayed);
            toolTable = resultData;
            console.log("i am in gettools information"); //need cleanup
            console.log(toolTable.length);  //need cleanup
        })
    } ;
/*self.pagination = function()
{
    var partitionNumber=25;
    this.paginated = computed(function() {
        var first = self.pageNumber() * partitionNumber;
        return(self.all.slice(first, first + first * self.partitionNumber))
    })

}*/

    self.enterSearch = function(value,e){    //function called when enter key is pressed and directs to search function

        if (e.keyCode === 13) {
            self.search();
        }
        return true;
    };


   self.search = function()                  // function that search with toolname
   {
        var matchedItems = [];
        var textinput=self.query();
        self.tools.removeAll();

       for (var index = 0, len = toolTable.length; index < len; index++) {

           if (toolTable[index].toolName.toLowerCase().indexOf(textinput.toLowerCase()) >= 0) {

               matchedItems.push(toolTable[index]);
           }
       }
        ko.mapping.fromJS(matchedItems, self.tools);


   };

   self.query.subscribe(self.search);

    self.initialize = function initialize ( )
    {
        self.getToolsInformation();
        self.getVendorNames();
    } ;


    self.getVendorNames = function ( ) {
        $.getJSON("/tis/vendors/names", function(resultData) {
            for ( i=0;i<resultData.length;i++) {
                self.vendors.push (resultData[i]) ;
            }
        })
    } ;

    self.changeAssignment = function ( ) {
        // Show the editable columns
    };

    // For edits

    self.editingItem = ko.observable();
    self.isItemEditing = function(itemToTest) {
        return itemToTest == self.editingItem();
    };

    self.editTool = function (tool) {
        if (self.editingItem() == null) {
            // shows the edit fields
            self.editingItem(tool);
        }
    };

    self.applyTool = function (tool) {
        $.ajax({
           url:"/tis/tools/"+tool.toolId()+"/vendor/"+self.selectedVendor(),
           type:"PUT",
           success:function(){
               self.getToolsInformation();
           }
    });
        //  hides the edit fields
        self.editingItem(null);
    };

    self.cancelEdit = function (tool) {
        //  hides the edit fields
        self.editingItem(null);
    };

    self.removeVendor = function(data){
        $.ajax({
            url:"/tis/tools/"+data.toolId(),
            type:"PUT",
            success:function(){
                self.getToolsInformation();
            }
        });
        self.editingItem(null);
    };

}