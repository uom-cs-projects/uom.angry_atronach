/**
 * Visualization of the Function dependency graph.
 */
var visualization = (function () {
  'use strict';

  var config = {
    width: 960,
    height: 500,
    colour: "#555",
    node_radius: 10,
    edge_width: 2
  };

  /**
   * Converts supplied data into the format required for D3.
   */
  function asD3Graph(data) {
    var graph = {"nodes": data.nodes, "links": []};

    data.links.forEach(function(e) {
      var source = data.nodes.find(function(n) {
        return n.uuid === e.source;
      });

      var target = data.nodes.find(function(n) {
        return n.uuid === e.target;
      });

      graph.links.push({"source": source, "target": target});
    });

    return graph;
  }

  /**
   * Initialization logic
   */
  var init = {
    svg: function(cfg) {
      return d3.select("#graph")
        .append("svg")
          .attr("width", cfg.width)
          .attr("height", cfg.height);
    },

    force: function(graph, cfg) {
      return d3.layout.force()
        .charge(-120)
        .linkDistance(4 * cfg.node_radius)
        .size([cfg.width, cfg.height])
        .nodes(graph.nodes)
        .links(graph.links);
    },

    link: function(graph, cfg, svg) {
      return svg
        .selectAll(".dependsOn")
          .data(graph.links)
        .enter().append("line")
          .attr("class", "dependsOn")
          .style("stroke-width", cfg.edge_width);
    },

    node: function(graph, cfg, svg, force) {
      var node = svg
        .selectAll(".function")
          .data(graph.nodes)
        .enter().append("circle")
          .attr("class", "function")
          .attr("r", cfg.node_radius)
          .style("fill", cfg.colour)
          .call(force.drag);

      node.append("title")
        .text(function(d) { return d.description; });

      return node;
    }
  }; // init

  return {
    init: function(externalGraph) {
      var graph = asD3Graph(externalGraph)

      // Clear loading message
      d3.select("#graph").html("");

      // Inits
      var svg = init.svg(config);
      var force = init.force(graph, config);
      var link = init.link(graph, config, svg);
      var node = init.node(graph, config, svg, force);

      force.on("tick", function() {
        link.attr("x1", function(d) { return d.source.x; })
          .attr("y1", function(d) { return d.source.y; })
          .attr("x2", function(d) { return d.target.x; })
          .attr("y2", function(d) { return d.target.y; });

        node.attr("cx", function(d) { return d.x; })
          .attr("cy", function(d) { return d.y; });
      });

      force.start();
    }
  };
})();
